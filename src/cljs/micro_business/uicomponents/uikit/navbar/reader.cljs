(ns micro-business.uicomponents.uikit.navbar.reader)

(defn getNavigationBars [state navbarIDs]
  (let [navbars (map #(get-in state [:navbar/by-id %]) navbarIDs)
        navItems (state :navitem/by-id)
        updatedNavbars (map (fn [navbar]
                              (let [navItemDetails (map #(navItems (last %)) (navbar :navigationItems))
                                    newNavbar (assoc-in navbar [:navigationItems] (into [] navItemDetails))]
                                newNavbar)) navbars)]
    updatedNavbars))
