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

(defn add-new [req]
  (response {:asd "asd"}))