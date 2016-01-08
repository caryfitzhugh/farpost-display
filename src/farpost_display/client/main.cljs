(ns farpost-display.client.main
  (:require
    [reagent.core :as reagent]
    [dommy.core :as dom :refer-macros [sel sel1]]
    ))

(defn main
  []
  (let [ element (sel1 "main")]
    ;; Tell the auth controller to load the current user to start w/
    ;(reagent/render-component [layout/template app-state/current] element)
    (.log js/console "Loaded!")
    ))

(defn doc-ready-handler []
  (let[ ready-state (. js/document -readyState)]
    (if (= "complete" ready-state)
      (main))))

(defn on-doc-ready []
  (aset  js/document "onreadystatechange" doc-ready-handler ))

(on-doc-ready)
