(ns wakata.db
  (:require [clojure.java.jdbc :as j]))

(defonce db {:subprotocol "mysql"
             :subname "//localhost:3306/wakata"
             :user "wakata"
             :password "wakatapass"})

(defn rooms []
  (j/query db
    ["select * from Rooms"]))