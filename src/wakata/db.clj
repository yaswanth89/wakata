(ns wakata.db
  (:require [clojure.java.jdbc :as j]
            [honeysql.core :as sql]
            [honeysql.helpers :as h]))

(defonce db {:subprotocol "mysql"
             :subname "//localhost:3306/wakata"
             :user "wakata"
             :password "wakatapass"})

(defn rooms []
  (j/query db
    ["select * from Rooms"]))

(defn schedule-for-room [room from to latest]
  (let [query (-> (h/select :*)
                (h/from :bookings)
                (h/where [:and
                          [:= :RoomID room]
                          [:> :at latest]
                          [:and
                            [:>= :date from]
                            [:<= :date to]]])
                sql/format)
        _ (println query)]
    (j/query db query)))