(ns dasha-widgets.random
  (:require [clojure.core.async :as async :refer [<! >! go-loop chan]]))

(defn widget []
  (let [out (chan)]
    (go-loop []
      (<! (async/timeout 1000))
      (>! out (rand-nth (range 100)))
      (recur))
    out))
