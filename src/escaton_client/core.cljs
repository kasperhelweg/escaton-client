(ns escaton-client.core
  (:require [reagent.core :as reagent]))

(enable-console-print!)
(println "Edits to this text should show up in your developer console.")

;; a small react component
(defn card [color desc]
  [:h4 (name color) desc])

;; main app component
(defn app []
  [:div
   [card :#ffffff "card description"]])

;; define your app data so that it doesn't get over-written on reload
(defonce app-state (atom {:text "Hello world!"}))

(defn render []
  (reagent/render [app]
                  (js/document.getElementById "app")))

;; export for doc. js - see index.html
;; http://stackoverflow.com/questions/35706538/equivalent-of-document-readyfunction-in-clojurescript
(defn ^:export run []
  (render))

;; figwheel js-reload
(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  (render))

;; alias render
(def on-doc-ready render)

;; run app
(on-doc-ready)
