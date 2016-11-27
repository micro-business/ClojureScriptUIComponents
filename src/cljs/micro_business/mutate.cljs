(ns micro-business.mutate
  (:require
   [om.next :as om]))

(defmulti mutate om/dispatch)

(defmethod mutate 'item1/clicked
  [{:keys [state]} _ {:keys [name]}]
  (println "Test 1")
  {:action
   nil})

(defmethod mutate 'item2/clicked
  [{:keys [state]} _ {:keys [name]}]
  (println "Test 2")
  {:action
   nil})

(defmethod mutate 'item5/clicked
  [{:keys [state]} _ {:keys [name]}]
  (println "Test 5")
  {:action
   nil})
