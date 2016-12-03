(ns micro-business.reader
  (:require
   [micro-business.uicomponents.uikit.navbar.reader :as navbarreader]
   [om.next :as om]))

(defmulti read om/dispatch)

(defmethod read :navigationBars
  [{:keys [state] :as env} key params]
  (let [st @state
        navBarIDs (map #(last %) (st key))
        navBars (map #(get-in st [:navBar/by-id %]) navBarIDs)
        navItems (st :navItem/by-id)
        updatedNavBars (navbarreader/getNavigationBars navBars navItems)]
    {:value updatedNavBars}))
