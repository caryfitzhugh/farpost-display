(ns farpost-display.routes.home
  (:require [compojure.core :refer :all]
            [farpost-display.views.layout :as layout]))

(defn home []
  (layout/common [:h1 "Hello World!"]))

(defroutes home-routes
  (GET "/" [] (home)))
