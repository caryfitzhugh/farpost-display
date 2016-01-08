(ns farpost-display.client.views
  (:require [reagent.core :as r]
            ))

(defn main-display [s]
  [:div.main-display
    [:div.header
      [:span "Far Post Soccer"]
      [:span.date-time  (:current-time @s)]
    ]
    [:div.fields
      [:div.current
        [:span.home-team "FP U12 Busby Babes"
          [:span.record "(8-1-1)"]
        ]
        [:span.vs "vs"]
        [:span.home-team "FP U12 Busby Babes"
          [:span.record "(8-1-1)"]
         ]
      ]
    ]
  ])
