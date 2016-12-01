(ns micro-business.uicomponents.uikit.reader
  (:require
   [om.next :as om]))

(defn getNavigationBars [state navbarKeys]
  (let [navbars (map #(get-in state [:navbar/by-id %]) navbarKeys)
        navItems (state :navitem/by-id)
        updatedNavbars (map (fn [navbar]
                              (let [navItemIDs (map #(last %) (navbar :navigationItems))
                                    navItemDetails (map #(navItems %) navItemIDs)
                                    newNavbar (assoc-in navbar [:navigationItems] (into [] navItemDetails))]
                                newNavbar)) navbars)]
    updatedNavbars))
