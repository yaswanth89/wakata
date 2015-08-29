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
                sql/format)]
    (j/query db query)))

(defn check-prev-entry [room slot date]
  (let [query (-> (h/select :%count.*)
                (h/from :bookings)
                (h/where [:and
                          [:= :RoomID room]
                          [:= :slot slot]
                          [:= :date date]])
                sql/format)]
    (j/query db query)))

(defn insert-booking [room slot date doneby]
    (j/insert! db "bookings" {:RoomID room
                              :slot slot
                              :date date
                              :doneby doneby}))

(defn insert-room [roomName]
  (j/insert! db "Rooms" {:RoomName roomName}))