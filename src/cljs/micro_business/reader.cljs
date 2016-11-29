(ns micro-business.reader
  (:require
   [om.next :as om :refer-macros [defui]]))

(defmulti read om/dispatch)

(defmethod read :navigationBars
  [{:keys [state] :as env} key params]
  (let [st @state
        navbarKeys (map #(last %) (st key))
        navbars (map #(get-in st [:navbar/by-id %]) navbarKeys)]
    {:value navbars}))
