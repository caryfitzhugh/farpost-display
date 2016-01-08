(ns farpost-display.styles.application
 (:require
   [garden.def :refer [defstyles defkeyframes]]
   [garden.color :as color :refer [hsl rgb]]
   [garden.stylesheet :refer [at-media]]
   [garden.arithmetic :as css-arith]
   [garden.units :refer [px]]))

(defstyles all
  [:body {
          :width "100%"
          :height "100%"
          :font-family "'Varela Round',sans-serif"
          :color "#444"
          :background-color "#efefef"
          }
])
