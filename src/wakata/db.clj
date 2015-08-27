(ns wakata.db
  (:require [clojure.contrib.sql :as sql]))

(defonce db {:classname "com.mysql.jdbc.Driver"
         :subprotocol "mysql"
         :subname "//localhost:3306/wakata"
         :user "wakata"
         :password "wakatapass"})