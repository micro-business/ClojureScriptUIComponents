(ns micro-business.uicomponents.uikit.navbar.reader)

(defn getNavigationBars [state]
  (let [navItems (state :navItem/by-id)
        navBars (state :navBar/by-id)
        updatedNavBars (map (fn [navBar]
                              (let [detailPart (last navBar)
                                    navItemDetails (map #(navItems (last %)) (detailPart :navigationItems))
                                    newNavBar (assoc-in detailPart [:navigationItems] (into [] navItemDetails))]
                                newNavBar)) navBars)]
    updatedNavBars))
