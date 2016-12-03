(ns micro-business.uicomponents.uikit.navbar.reader)

(defn getNavigationBars [navBars navItems]
  (let [updatedNavBars (map (fn [navBar]
                              (let [navItemDetails (map #(navItems (last %)) (navBar :navigationItems))
                                    newNavBar (assoc-in navBar [:navigationItems] (into [] navItemDetails))]
                                newNavBar)) navBars)]
    updatedNavBars))
