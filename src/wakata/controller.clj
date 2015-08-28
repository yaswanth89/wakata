(ns wakata.controller
  (:require [wakata.db :as db]
            [clj-time.coerce :as c]
            [ring.util.response :refer [response]]))

(defn clean-time [obj key]
  (update-in obj [key]  #(c/to-long (c/from-sql-time %))))

(defn schedules [{:keys [room from to at] :as req}]
  (when (every? seq [room from to at])
    (let [long-from (Long. from)
          long-to (Long. to)
          int-room (Integer. room)
          long-at (Long. at)
          resp (db/schedule-for-room int-room long-from long-to long-at)]
      (response resp))))

(defn rooms [req]
  (response (db/rooms)))

(defn add-new [req]
  (response {:asd "asd"}))