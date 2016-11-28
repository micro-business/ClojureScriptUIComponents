(ns micro-business.mutate
  (:require
   [om.next :as om]))

(defmulti mutate om/dispatch)

(defmethod mutate 'item1/clicked
  [{:keys [state]} _ {:keys [name]}]
  {:action
   (fn [] (println "Test 1"))})

(defmethod mutate 'item2/clicked
  [{:keys [state]} _ {:keys [name]}]
  {:action
   (fn [] (println "Test 2"))})

(defmethod mutate 'item5/clicked
  [{:keys [state]} _ {:keys [name]}]
  {:action
   (fn [] (println "Test 5"))})
