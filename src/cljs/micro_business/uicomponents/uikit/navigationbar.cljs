(ns micro-business.uicomponents.uikit.navigationbar
  (:require
   [om.next :as om :refer-macros [defui]]
   [om.dom :as dom]
   [micro-business.uicomponents.uikit.navigationitem :as navigationitem]))

(def getNavbarStyle #js {:className "uk-navbar"})
(def getNavbarFlipStyle #js {:className "uk-navbar-flip"})
(def getNavbarBrandStyle #js {:className "uk-navbar-brand" :href "#"})
(def getNavbarNavStyle #js {:className "uk-navbar-nav"})

(defn getNavigationItems [navigationItems]
  (dom/ul getNavbarNavStyle
          (map navigationitem/navItem navigationItems)))

(defn getNavbar [{:keys [brand rightToLeftAlignment navigationItems]}]
  (if rightToLeftAlignment
    (apply dom/nav getNavbarStyle [(dom/a getNavbarBrandStyle brand)
                                   (getNavigationItems navigationItems)])
    (apply dom/nav getNavbarStyle [(dom/a getNavbarBrandStyle brand)
                                   (dom/div getNavbarFlipStyle
                                            (getNavigationItems navigationItems))])))

(defui Navbar
  static om/IQuery
  (query [this]
         (let [navItemSubquery (om/get-query navigationitem/NavItem)]
           `[:brand :rightToLeftAlignment {:navigationitems ~navItemSubquery}]))
  Object
  (render [this]
          (getNavbar {:brand (-> this om/props :brand)
                      :rightToLeftAlignment (-> this om/props :rightToLeftAlignment)
                      :navigationItems (-> this om/props :navigationItems)})))

(def navbar (om/factory Navbar))
