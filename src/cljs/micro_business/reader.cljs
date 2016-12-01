(ns micro-business.reader
  (:require
   [micro-business.uicomponents.uikit.reader :as uikitreader]
   [om.next :as om]))

(defmulti read om/dispatch)

(defmethod read :navigationBars
  [{:keys [state] :as env} key params]
  (let [st @state
        navbarKeys (map #(last %) (st key))
        updatedNavbars (uikitreader/getNavigationBars st navbarKeys)]
    {:value updatedNavbars}))
