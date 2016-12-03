(ns micro-business.uicomponents.uikit.navbar.reader)

(defn getNavigationBars [state navigationBarsKey]
  (let [navBarIDs (map #(last %) (state navigationBarsKey))
        navBars (map #(get-in state [:navBar/by-id %]) navBarIDs)
        navItems (state :navItem/by-id)
        updatedNavBars (map (fn [navBar]
                              (let [navItemDetails (map #(navItems (last %)) (navBar :navigationItems))
                                    newNavBar (assoc-in navBar [:navigationItems] (into [] navItemDetails))]
                                newNavBar)) navBars)]
    updatedNavBars))
