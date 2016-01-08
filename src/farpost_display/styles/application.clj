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

   [:.main-display {
      :background :white
      :position :absolute
      :top 0
      :left 0
      :right 0
      :bottom 0
      :padding "10px"
   }
    [:.header
      { :background "rgb(255, 123, 27)"
        :color "#efefef" ;;"rgb(0,4,58)"
        :position :absolute
        :top 0
        :left 0
        :right 0
        :height "60px"
        :font-size "30px"
        :line-height "60px"
        :padding "0 20px"
        :text-align :left
      }
      [:.date-time { :position :absolute
                     :top 0
                     :right "20px"
                     :font-size "100%"
                     }
      ]
    ]
    [:.fields {
        :position :absolute
        :top "60px"
        :left 0
        :width "100%"
        :bottom 0
        :background "#111"
        :padding "20px"
              }
     [:.current {
        :width "100%"
        :border "1px solid black"
     }]

    ]
   ]
])
