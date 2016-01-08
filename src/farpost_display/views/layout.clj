(ns farpost-display.views.layout
  (:require [hiccup.page :refer [html5 include-css]]))

(defn common [& body]
  (html5
    [:head
     [:title "Welcome to farpost-display"]
     (include-css "/css/screen.css")]
    [:body body]))
