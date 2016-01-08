(ns farpost-display.routes.home
  (:require [compojure.core :refer :all]
            [farpost-display.views.layout :as layout]))

(defn home []
  (layout/common
    [:div
     [:h1 "FarPost Soccer Club"]
     [:div#main]

     [:script {:src "/js/app.js"}]
    ]))

(defroutes home-routes
  (GET "/" [] (home)))
