(ns micro-business.uicomponents.uikit
  (:require
   [om.next :as om :refer-macros [defui]]
   [om.dom :as dom]))

(def getNavbarStyle #js {:className "uk-navbar"})
(def getNavbarBrandStyle #js {:className "uk-navbar-brand" :href "#"})
(def getNavbarNavStyle #js {:className "uk-navbar-nav"})

(defn getNavbar [{:keys [brand navigationItems]}]
  (apply dom/nav getNavbarStyle [(dom/a getNavbarBrandStyle brand)
                                 (dom/ul getNavbarNavStyle
                                         (map navItem navigationItems))]))

(defui Navbar
  static om/IQuery
  (query [this]
         (let [navItemSubquery (om/get-query NavItem)]
           `[:brand {:navigationitems ~navItemSubquery}]))
  Object
  (render [this]
          (getNavbar {:brand (-> this om/props :brand)
                      :navigationItems (-> this om/props :navigationItems)})))

(def navbar (om/factory Navbar))
