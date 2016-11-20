(ns micro-business.reader
  (:require
   [om.next :as om :refer-macros [defui]]))

(defmulti read om/dispatch)

(defmethod read :navigationBar
  [{:keys [state] :as env} key params]
  {:value (@state key)})
