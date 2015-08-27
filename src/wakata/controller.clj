(ns wakata.controller
  (:require [wakata.db :as db]))

(defn schedules [:keys [request-method] :as req]
  (println request-method))

(defn add-new [:keys [request-method] :as req]
  (println request-method))