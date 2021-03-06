(defproject farpost-display "0.1.0-SNAPSHOT"
  :description ""
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [compojure "1.4.0"]
                 [hiccup "1.0.5"]
                 [ring-server "0.3.1"]
                 [ring/ring-servlet "1.4.0"]

                 [org.clojure/data.json "0.2.5"]
                 [garden "1.2.5"]
                 [environ               "1.0.0"]

                 [org.clojure/clojurescript "1.7.228" :exclusions [org.clojure/data.json]]
                 [prismatic/dommy "1.0.0"]
                 [reagent "0.5.1" :exclusions [org.clojure/data.json]]
                 [secretary "1.2.3"]
                 [cljs-ajax "0.3.14" :exclusions [org.clojure/data.json]]
                 [com.andrewmcveigh/cljs-time "0.4.0"]
                 ]


  :plugins [[lein-ring "0.9.1"]
            [lein-cljsbuild "1.1.1"]
            [lein-garden "0.2.5" :exclusions [org.clojure/java.classpath org.clojure/clojure]]
            [lein-environ "1.0.0"]
            ]

  :ring {:handler farpost-display.handler/app
         :init farpost-display.handler/init
         :destroy farpost-display.handler/destroy}

  :clean-targets ^{:protect false} ["resources/public/css/application.css"]

  :garden {:builds [{
                     ;; Source paths where the stylesheet source code is
                     :source-paths ["src/farpost_display/styles/application"]
                     ;; The var containing your stylesheet:
                     :stylesheet farpost-display.styles.application/all
                     ;; Compiler flags passed to `garden.core/css`:
                     :compiler {;; Where to save the file:
                                :output-to "resources/public/css/application.css"
                                :vendors [:moz :webkit]
                                ;; Compress the output?
                                :pretty-print? true}}]}

  :cljsbuild {
      :builds
            [
             {:id "dev"
              :source-paths ["src/farpost_display/client"]
              :compiler {
                         :output-to "resources/public/js/app.js"
                         :output-dir "resources/public/js/compiled/"
                         :asset-path "js/compiled"
                         :optimizations :none
                         :main "farpost_display.client.main"
                         :pretty-print true}
             }

             {:id "production"
              :source-paths ["src/farpost_display/client"]
              :compiler {
                         :output-to "resources/public/js/app.min.js"
                         :output-dir "resources/public/js/minified"
                         :main "farpost_display.client.main"
                         :optimizations :whitespace
                         }
             }
          ]
  }

  :uberjar-name "farpost-display.uber.jar"

  :hooks [leiningen.garden
          leiningen.cljsbuild]

  :min-lein-version "2.4.3"
  :profiles
    {:uberjar {:aot :all }
     :production
     {:ring
      {:open-browser? false, :stacktraces? false, :auto-reload? false}}
     :dev
     {:dependencies [[ring-mock "0.1.5"]
                     [ring/ring-devel "1.3.1" :exclusions [org.clojure/java.classpath]]

                     ]}})
