(ns farpost-display.client.main
  (:require
    [reagent.core :as reagent]
    [cljs-time.core :as t]
    [cljs-time.format :as tf]
    [farpost-display.client.views :as views]
    [dommy.core :as dom :refer-macros [sel sel1]]
    ))

(def app-state
  (reagent/atom {}))

(defn main
  []
  (let [ element (sel1 "#main")]
    ;; Tell the auth controller to load the current user to start w/
    (reagent/render-component [views/main-display app-state] element)
    ))

(defn doc-ready-handler []
  (let[ ready-state (. js/document -readyState)]
    (if (= "complete" ready-state)
      (main))))

(defn on-doc-ready []
  (aset  js/document "onreadystatechange" doc-ready-handler ))

(on-doc-ready)

(defn- to-time [the-time]
  (let [local-offset (.getTimezoneOffset (js/Date.)) ]
      (let [local-the-time (t/minus the-time (t/minutes local-offset))]
        local-the-time)))

(js/setInterval (fn []
    (swap! app-state (fn [current]
                       (assoc current :current-time (tf/unparse (tf/formatter "hh:mm A") (to-time (t/now))))
                       ))
    )
    1000)
