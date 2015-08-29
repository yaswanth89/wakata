(ns wakata.controller
  (:require [wakata.db :as db]
            [clj-time.coerce :as c]
            [ring.util.response :refer [response]]))

(defn clean-time [obj key]
  (update-in obj [key]  #(c/to-long (c/from-sql-time %))))

(defn schedules [{:keys [room from to at] :as req}]
  (when (every? seq [room from to at])
    (let [resp (db/schedule-for-room room from to at)]
      (response resp))))

(defn rooms [req]
  (response (db/rooms)))

(defn book [{:keys [room slot date doneby] :as req}]
  (when (and
          (every? seq [room slot date doneby])
          (zero? ((keyword "count(*)")
            (first
              (db/check-prev-entry room slot date)))))
    (response
      (db/insert-booking room slot date doneby))))