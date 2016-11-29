(ns micro-business.mutate
  (:require
   [om.next :as om]))

(defmulti mutate om/dispatch)

(defmethod mutate 'item1-1/clicked
  [{:keys [state]} _ {:keys [name]}]
  {:action
   (fn [] (println "Test 1-1"))})

(defmethod mutate 'item1-2/clicked
  [{:keys [state]} _ {:keys [name]}]
  {:action
   (fn [] (println "Test 1-2"))})

(defmethod mutate 'item1-5/clicked
  [{:keys [state]} _ {:keys [name]}]
  {:action
   (fn [] (println "Test 1-5"))})

(defmethod mutate 'item2-1/clicked
  [{:keys [state]} _ {:keys [name]}]
  {:action
   (fn [] (println "Test 2-1"))})

(defmethod mutate 'item2-2/clicked
  [{:keys [state]} _ {:keys [name]}]
  {:action
   (fn [] (println "Test 2-2"))})

(defmethod mutate 'item2-5/clicked
  [{:keys [state]} _ {:keys [name]}]
  {:action
   (fn [] (println "Test 2-5"))})
