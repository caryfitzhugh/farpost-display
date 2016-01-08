(ns farpost-display.views.layout
  (:require [hiccup.page :refer [html5 include-css]]))

(defn common [& body]
  (html5
    [:head
      [:title "Welcome to farpost-display"]
      [:link {:href 'https://fonts.googleapis.com/css?family=Varela+Round' :rel 'stylesheet' :type 'text/css'}]
      (include-css "/css/application.css")
    ]
    [:body body]))
