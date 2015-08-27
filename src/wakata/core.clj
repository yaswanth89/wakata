(ns wakata.core
  (:gen-class)
  (:require [wakata.http :as http]))

(defn -main []
  (http/start-server 3000))