(ns micro-business.reader
  (:require
   [micro-business.uicomponents.uikit.navbar.reader :as navbarreader]
   [om.next :as om]))

(defmulti read om/dispatch)

(defmethod read :navigationBars
  [{:keys [state] :as env} key params]
  {:value (navbarreader/getNavigationBars @state key)})
