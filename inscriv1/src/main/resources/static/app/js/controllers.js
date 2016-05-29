'use strict';

angular.module('xenon.controllers', []).controller('LoginCtrl', function ($scope, $rootScope) {
    $rootScope.isLoginPage = true;
    $rootScope.isLightLoginPage = false;
    $rootScope.isLockscreenPage = false;
    $rootScope.isMainPage = false;
}).controller('LoginLightCtrl', function ($scope, $rootScope) {
    $rootScope.isLoginPage = true;
    $rootScope.isLightLoginPage = true;
    $rootScope.isLockscreenPage = false;
    $rootScope.isMainPage = false;
}).controller('LockscreenCtrl', function ($scope, $rootScope) {
    $rootScope.isLoginPage = false;
    $rootScope.isLightLoginPage = false;
    $rootScope.isLockscreenPage = true;
    $rootScope.isMainPage = false;
}).controller('MainCtrl', function ($scope, $state, $rootScope, $location, $layout, $layoutToggles, $pageLoadingBar, Fullscreen, $http, profilDataService, userIdService, userInscriService) {


    /*********  login page functions  ********/
    $scope.connexion = function (user) {

        console.log(user);

        $http.post("http://localhost:8080/auth1", user).
            //$http.post('http://10.10.10.50:8080/app/personne/auth',person).
            success(function (respons) {
                var role = respons.role;
                var id = respons.id;
                userIdService.setValue(id);
                userInscriService.setValue(respons);
                console.log(role);

                if (role == "recruteur") {
                    //$location.path("/recruteur");
                    $state.go('appR.recruteur');

                } else if (role == "candidat") {
                    $http.get("http://localhost:8080/profilCand/" + id).success(function (respons) {
                        console.log(respons);
                        var profileData = respons;
                        profilDataService.setValue(profileData);
                        console.log(JSON.stringify(profileData));
                        console.log(profileData);
                        console.log("okiiii");
                        $state.go('appC.candidat');
                    })

                }
                else if (role == "admin") {
                    $state.go('app.adminGestion');
                }
                else if (role=="") {
                    $scope.msglogin = "Votre login ou mot de passe est incorrect.";

                }
            })
            .error(function (data, Status, Response) {
                $scope.data = data;
                $scope.status = Status;
                console.log(data);
                console.log(Response);
                console.log(Status);
                console.log('fail');
            });
    };

    $scope.getforgotPassword = function () {
        $state.go('forgottenPassword');
    };

    $scope.sentPassword = function (loginForgot) {
        $scope.forgotPassword = false;
        $http.get("http://localhost:8080/recupMail/" + loginForgot).success(function (reponse) {
            $scope.msgForgetPassword = "Consulter votre boite Mail pour récupérer votre mot de passe.";
            $state.go('login-light');
        })
    };

    $rootScope.isLoginPage = false;
    $rootScope.isLightLoginPage = false;
    $rootScope.isLockscreenPage = false;
    $rootScope.isMainPage = true;

    $rootScope.layoutOptions = {
        horizontalMenu: {
            isVisible		: false,
            isFixed			: true,
            minimal			: false,
            clickToExpand	: false,

            isMenuOpenMobile: false
        },
        sidebar: {
            isVisible: true,
            isCollapsed: false,
            toggleOthers: true,
            isFixed: true,
            isRight: false,

            isMenuOpenMobile: false,

            // Added in v1.3
            userProfile: true
        },
        chat: {
            isOpen: false,
        },
        settingsPane: {
            isOpen: false,
            useAnimation: true
        },
        container: {
            isBoxed: false
        },
        skins: {
            sidebarMenu: '',
            horizontalMenu	: '',
            userInfoNavbar: ''
        },
        pageTitles: true,
        userInfoNavVisible: false
    };

    $layout.loadOptionsFromCookies(); // remove this line if you don't want to support cookies that remember layout changes


    $scope.updatePsScrollbars = function () {
        var $scrollbars = jQuery(".ps-scrollbar:visible");

        $scrollbars.each(function (i, el) {
            if (typeof jQuery(el).data('perfectScrollbar') == 'undefined') {
                jQuery(el).perfectScrollbar();
            }
            else {
                jQuery(el).perfectScrollbar('update');
            }
        })
    };


    // Define Public Vars
    public_vars.$body = jQuery("body");


    // Init Layout Toggles
    $layoutToggles.initToggles();


    // Other methods
    $scope.setFocusOnSearchField = function () {
        public_vars.$body.find('.search-form input[name="s"]').focus();

        setTimeout(function () {
            public_vars.$body.find('.search-form input[name="s"]').focus()
        }, 100);
    };


    // Watch changes to replace checkboxes
    $scope.$watch(function () {
        cbr_replace();
    });

    // Watch sidebar status to remove the psScrollbar
    $rootScope.$watch('layoutOptions.sidebar.isCollapsed', function (newValue, oldValue) {
        if (newValue != oldValue) {
            if (newValue == true) {
                public_vars.$sidebarMenu.find('.sidebar-menu-inner').perfectScrollbar('destroy')
            }
            else {
                public_vars.$sidebarMenu.find('.sidebar-menu-inner').perfectScrollbar({wheelPropagation: public_vars.wheelPropagation});
            }
        }
    });


    // Page Loading Progress (remove/comment this line to disable it)
    $pageLoadingBar.init();

    $scope.showLoadingBar = showLoadingBar;
    $scope.hideLoadingBar = hideLoadingBar;


    // Set Scroll to 0 When page is changed
    $rootScope.$on('$stateChangeStart', function () {
        var obj = {pos: jQuery(window).scrollTop()};

        TweenLite.to(obj, .25, {
            pos: 0, ease: Power4.easeOut, onUpdate: function () {
                $(window).scrollTop(obj.pos);
            }
        });
    });


    // Full screen feature added in v1.3
    $scope.isFullscreenSupported = Fullscreen.isSupported();
    $scope.isFullscreen = Fullscreen.isEnabled() ? true : false;

    $scope.goFullscreen = function () {
        if (Fullscreen.isEnabled())
            Fullscreen.cancel();
        else
            Fullscreen.all();

        $scope.isFullscreen = Fullscreen.isEnabled() ? true : false;
    }

}).controller('SidebarMenuCtrl', function ($scope, $rootScope, $menuItems, $timeout, $location, $state, $layout) {

    // Menu Items
    var $sidebarMenuItems = $menuItems.instantiate();

    $scope.menuItems = $sidebarMenuItems.prepareSidebarMenu().getAll();

    // Set Active Menu Item
    $sidebarMenuItems.setActive($location.path());

    $rootScope.$on('$stateChangeSuccess', function () {
        $sidebarMenuItems.setActive($state.current.name);
    });

    // Trigger menu setup
    public_vars.$sidebarMenu = public_vars.$body.find('.sidebar-menu');
    $timeout(setup_sidebar_menu, 1);

    ps_init(); // perfect scrollbar for sidebar
}).controller('SidebarMenuCtrlc', function ($scope, $rootScope, $menuItemsc, $timeout, $location, $state, $layout) {

    // Menu Items
    var $sidebarMenuItems = $menuItemsc.instantiate();

    $scope.menuItems = $sidebarMenuItems.prepareSidebarMenu().getAll();

    // Set Active Menu Item
    $sidebarMenuItems.setActive($location.path());

    $rootScope.$on('$stateChangeSuccess', function () {
        $sidebarMenuItems.setActive($state.current.name);
    });

    // Trigger menu setup
    public_vars.$sidebarMenu = public_vars.$body.find('.sidebar-menu');
    $timeout(setup_sidebar_menu, 1);

    ps_init(); // perfect scrollbar for sidebar
}).
controller('HorizontalMenuCtrl', function($scope, $rootScope, $menuItems, $timeout, $location, $state)
{
    var $horizontalMenuItems = $menuItems.instantiate();

    $scope.menuItems = $horizontalMenuItems.prepareHorizontalMenu().getAll();

    // Set Active Menu Item
    $horizontalMenuItems.setActive( $location.path() );

    $rootScope.$on('$stateChangeSuccess', function()
    {
        $horizontalMenuItems.setActive($state.current.name);

        $(".navbar.horizontal-menu .navbar-nav .hover").removeClass('hover'); // Close Submenus when item is selected
    });

    // Trigger menu setup
    $timeout(setup_horizontal_menu, 1);
}).


controller('SettingsPaneCtrl', function ($rootScope) {
    // Define Settings Pane Public Variable
    public_vars.$settingsPane = public_vars.$body.find('.settings-pane');
    public_vars.$settingsPaneIn = public_vars.$settingsPane.find('.settings-pane-inner');
}).controller('SidebarMenuCtrlr', function ($scope, $rootScope, $menuItemsr, $timeout, $location, $state, $layout) {

    // Menu Items
    var $sidebarMenuItems = $menuItemsr.instantiate();

    $scope.menuItems = $sidebarMenuItems.prepareSidebarMenu().getAll();

    // Set Active Menu Item
    $sidebarMenuItems.setActive($location.path());

    $rootScope.$on('$stateChangeSuccess', function () {
        $sidebarMenuItems.setActive($state.current.name);
    });

    // Trigger menu setup
    public_vars.$sidebarMenu = public_vars.$body.find('.sidebar-menu');
    $timeout(setup_sidebar_menu, 1);

    ps_init(); // perfect scrollbar for sidebar
}).controller('SettingsPaneCtrl', function ($rootScope) {
    // Define Settings Pane Public Variable
    public_vars.$settingsPane = public_vars.$body.find('.settings-pane');
    public_vars.$settingsPaneIn = public_vars.$settingsPane.find('.settings-pane-inner');
}).controller('UIModalsCtrl', function ($scope, $rootScope, $modal, $sce) {
    // Open Simple Modal
    $scope.openModal = function (modal_id, modal_size, modal_backdrop) {
        $rootScope.currentModal = $modal.open({
            templateUrl: modal_id,
            size: modal_size,
            backdrop: typeof modal_backdrop == 'undefined' ? true : modal_backdrop
        });
    };

    // Loading AJAX Content
    $scope.openAjaxModal = function (modal_id, url_location) {
        $rootScope.currentModal = $modal.open({
            templateUrl: modal_id,
            resolve: {
                ajaxContent: function ($http) {
                    return $http.get(url_location).then(function (response) {
                        $rootScope.modalContent = $sce.trustAsHtml(response.data);
                    }, function (response) {
                        $rootScope.modalContent = $sce.trustAsHtml('<div class="label label-danger">Cannot load ajax content! Please check the given url.</div>');
                    });
                }
            }
        });

        $rootScope.modalContent = $sce.trustAsHtml('Modal content is loading...');
    }
}).controller('PaginationDemoCtrl', function ($scope) {
    $scope.totalItems = 64;
    $scope.currentPage = 4;

    $scope.setPage = function (pageNo) {
        $scope.currentPage = pageNo;
    };

    $scope.pageChanged = function () {
        console.log('Page changed to: ' + $scope.currentPage);
    };

    $scope.maxSize = 5;
    $scope.bigTotalItems = 175;
    $scope.bigCurrentPage = 1;
}).controller('LayoutVariantsCtrl', function ($scope, $layout, $cookies) {
    $scope.opts = {
        sidebarType: null,
        fixedSidebar: null,
        sidebarToggleOthers: null,
        sidebarVisible: null,
        sidebarPosition: null,

        horizontalVisible: null,
        fixedHorizontalMenu: null,
        horizontalOpenOnClick: null,
        minimalHorizontalMenu: null,

        sidebarProfile: null
    };

    $scope.sidebarTypes = [
        {value: ['sidebar.isCollapsed', false], text: 'Expanded', selected: $layout.is('sidebar.isCollapsed', false)},
        {value: ['sidebar.isCollapsed', true], text: 'Collapsed', selected: $layout.is('sidebar.isCollapsed', true)},
    ];

    $scope.fixedSidebar = [
        {value: ['sidebar.isFixed', true], text: 'Fixed', selected: $layout.is('sidebar.isFixed', true)},
        {value: ['sidebar.isFixed', false], text: 'Static', selected: $layout.is('sidebar.isFixed', false)},
    ];

    $scope.sidebarToggleOthers = [
        {value: ['sidebar.toggleOthers', true], text: 'Yes', selected: $layout.is('sidebar.toggleOthers', true)},
        {value: ['sidebar.toggleOthers', false], text: 'No', selected: $layout.is('sidebar.toggleOthers', false)},
    ];

    $scope.sidebarVisible = [
        {value: ['sidebar.isVisible', true], text: 'Visible', selected: $layout.is('sidebar.isVisible', true)},
        {value: ['sidebar.isVisible', false], text: 'Hidden', selected: $layout.is('sidebar.isVisible', false)},
    ];

    $scope.sidebarPosition = [
        {value: ['sidebar.isRight', false], text: 'Left', selected: $layout.is('sidebar.isRight', false)},
        {value: ['sidebar.isRight', true], text: 'Right', selected: $layout.is('sidebar.isRight', true)},
    ];

    $scope.horizontalVisible = [
        {value: ['horizontalMenu.isVisible', true], text: 'Visible', selected: $layout.is('horizontalMenu.isVisible', true)},
        {value: ['horizontalMenu.isVisible', false], text: 'Hidden', selected: $layout.is('horizontalMenu.isVisible', false)},
    ];

    $scope.fixedHorizontalMenu = [
        {value: ['horizontalMenu.isFixed', true], text: 'Fixed', selected: $layout.is('horizontalMenu.isFixed', true)},
        {value: ['horizontalMenu.isFixed', false], text: 'Static', selected: $layout.is('horizontalMenu.isFixed', false)},
    ];

    $scope.horizontalOpenOnClick = [
        {value: ['horizontalMenu.clickToExpand', false], text: 'No', selected: $layout.is('horizontalMenu.clickToExpand', false)},
        {value: ['horizontalMenu.clickToExpand', true], text: 'Yes', selected: $layout.is('horizontalMenu.clickToExpand', true)},
    ];

    $scope.minimalHorizontalMenu = [
        {value: ['horizontalMenu.minimal', false], text: 'No', selected: $layout.is('horizontalMenu.minimal', false)},
        {value: ['horizontalMenu.minimal', true], text: 'Yes', selected: $layout.is('horizontalMenu.minimal', true)},
    ];

    $scope.boxedContainer = [
        {value: ['container.isBoxed', false], text: 'No', selected: $layout.is('container.isBoxed', false)},
        {value: ['container.isBoxed', true], text: 'Yes', selected: $layout.is('container.isBoxed', true)},
    ];

    $scope.sidebarProfile = [
        {value: ['sidebar.userProfile', false], text: 'No', selected: $layout.is('sidebar.userProfile', false)},
        {value: ['sidebar.userProfile', true], text: 'Yes', selected: $layout.is('sidebar.userProfile', true)},
    ];

    $scope.resetOptions = function () {
        $layout.resetCookies();
        window.location.reload();
    };

    var setValue = function (val) {
        if (val != null) {
            val = eval(val);
            $layout.setOptions(val[0], val[1]);
        }
    };

    $scope.$watch('opts.sidebarType', setValue);
    $scope.$watch('opts.fixedSidebar', setValue);
    $scope.$watch('opts.sidebarToggleOthers', setValue);
    $scope.$watch('opts.sidebarVisible', setValue);
    $scope.$watch('opts.sidebarPosition', setValue);

    $scope.$watch('opts.horizontalVisible', setValue);
    $scope.$watch('opts.fixedHorizontalMenu', setValue);
    $scope.$watch('opts.horizontalOpenOnClick', setValue);
    $scope.$watch('opts.minimalHorizontalMenu', setValue);

    $scope.$watch('opts.chatVisibility', setValue);

    $scope.$watch('opts.boxedContainer', setValue);

    $scope.$watch('opts.sidebarProfile', setValue);
}).controller('ThemeSkinsCtrl', function ($scope, $layout) {
    var $body = jQuery("body");

    $scope.opts = {
        sidebarSkin: $layout.get('skins.sidebarMenu'),
        horizontalMenuSkin: $layout.get('skins.horizontalMenu'),
        userInfoNavbarSkin: $layout.get('skins.userInfoNavbar')
    };

    $scope.skins = [
        {value: '', name: 'Default', palette: ['#2c2e2f', '#EEEEEE', '#FFFFFF', '#68b828', '#27292a', '#323435']},
        {value: 'aero', name: 'Aero', palette: ['#558C89', '#ECECEA', '#FFFFFF', '#5F9A97', '#558C89', '#255E5b']},
        {value: 'navy', name: 'Navy', palette: ['#2c3e50', '#a7bfd6', '#FFFFFF', '#34495e', '#2c3e50', '#ff4e50']},
        {
            value: 'facebook',
            name: 'Facebook',
            palette: ['#3b5998', '#8b9dc3', '#FFFFFF', '#4160a0', '#3b5998', '#8b9dc3']
        },
        {
            value: 'turquoise',
            name: 'Truquoise',
            palette: ['#16a085', '#96ead9', '#FFFFFF', '#1daf92', '#16a085', '#0f7e68']
        },
        {value: 'lime', name: 'Lime', palette: ['#8cc657', '#ffffff', '#FFFFFF', '#95cd62', '#8cc657', '#70a93c']},
        {value: 'green', name: 'Green', palette: ['#27ae60', '#a2f9c7', '#FFFFFF', '#2fbd6b', '#27ae60', '#1c954f']},
        {value: 'purple', name: 'Purple', palette: ['#795b95', '#c2afd4', '#FFFFFF', '#795b95', '#27ae60', '#5f3d7e']},
        {value: 'white', name: 'White', palette: ['#FFFFFF', '#666666', '#95cd62', '#EEEEEE', '#95cd62', '#555555']},
        {
            value: 'concrete',
            name: 'Concrete',
            palette: ['#a8aba2', '#666666', '#a40f37', '#b8bbb3', '#a40f37', '#323232']
        },
        {
            value: 'watermelon',
            name: 'Watermelon',
            palette: ['#b63131', '#f7b2b2', '#FFFFFF', '#c03737', '#b63131', '#32932e']
        },
        {
            value: 'lemonade',
            name: 'Lemonade',
            palette: ['#f5c150', '#ffeec9', '#FFFFFF', '#ffcf67', '#f5c150', '#d9a940']
        },
    ];

    $scope.$watch('opts.sidebarSkin', function (val) {
        if (val != null) {
            $layout.setOptions('skins.sidebarMenu', val);

            $body.attr('class', $body.attr('class').replace(/\sskin-[a-z]+/)).addClass('skin-' + val);
        }
    });

    $scope.$watch('opts.horizontalMenuSkin', function (val) {
        if (val != null) {
            $layout.setOptions('skins.horizontalMenu', val);

            $body.attr('class', $body.attr('class').replace(/\shorizontal-menu-skin-[a-z]+/)).addClass('horizontal-menu-skin-' + val);
        }
    });

    $scope.$watch('opts.userInfoNavbarSkin', function (val) {
        if (val != null) {
            $layout.setOptions('skins.userInfoNavbar', val);

            $body.attr('class', $body.attr('class').replace(/\suser-info-navbar-skin-[a-z]+/)).addClass('user-info-navbar-skin-' + val);
        }
    });
}).controller('fileCtrl', function ($scope, $rootScope, $location, $http, $state, userInscriService) {

    $scope.etape2 = function (user1) {
        $scope.user1 = user1;

        var file = $scope.myFile;
        var uploadUrl = "http://localhost:8080/upload";
        var fd = new FormData();
        fd.append('file', file);

        $http.post(uploadUrl, fd, {
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
            })
            .then(function (respons) {
                $scope.user2 = respons.data;

                //merge the two controllers from inscription1 and inscription2
               /* var user = {"nom":"slama","email":"mohamed@yahoo.fr","age":"25","adresse":"nabel","tel":"5567456","sexe":"male",

                 "diplomes":[{"nom":"licence","dateObtention":2011},{"nom":"bac","dateObtention":2008},{"nom":"ing","dateObtention":2010}],
                 "certifications":[{"nomCertif":"CISCO"},{"nomCertif":"SCJP"}],"technologies":[{"nomTechno":"java"},
                 {"nomTechno":".net"}],"login":"tayra","password":"tayara"};*/

                var user = angular.extend($scope.user2, $scope.user1);
                console.log(user);
                userInscriService.setValue(user);
                console.log(user);
                $state.go('inscri2');
            });
    };
}).controller('inscriCtrl', function ($scope, $http, userInscriService, $state) {
    $scope.user = userInscriService.getValue();

    console.log("ok");
    console.log($scope.user);
    $scope.user.experiences = [];
    $scope.addSkill = function () {

        $scope.user.experiences.push({
            domaine: $scope.user.experiences.domaine,
            nbrAnsExp: $scope.user.experiences.nbrAnsExp,
        })
        $scope.user.experiences.domaine = ''
        $scope.user.experiences.nbrAnsExp = ''
    };
    $scope.deleteSkill = function (index) {
        $scope.user.experiences.splice(index, 1);
    };
    $scope.addCertif = function () {
        $scope.user.certifications.push({
            nomCertif: $scope.certification.newNomCertif,
        })
        $scope.certification.newNomCertif = ''
    };
    $scope.deleteCertif = function (index) {
        $scope.user.certifications.splice(index, 1);
    };
    $scope.deleteDiplome = function (index) {
        $scope.user.diplomes.splice(index, 1);
    };

    $scope.inscription = function (user) {

        console.log(JSON.stringify(user));

        $http.post("http://localhost:8080/inscri", user).
            //$http.post('http://10.10.10.50:8080/app/personne/auth',person).
            success(function (respons) {
                console.log(respons);
                $state.go('login-light');
            })
            .error(function (data, Status, Response) {
                $scope.data = data;
                $scope.status = Status;
                console.log(data);
                console.log(Response);
                console.log(Status);
                console.log('fail');
            });
    };
}).controller('adminGestionCtrl', function ($scope, $http, $state) {


    var recruteur = {
        'login': '',
        password: '',
        nomRecruteur: '',
        serviceRecruteur: '',
        role: 'recruteur'
    };
    $scope.consulterRec = function () {
        $http.get("http://localhost:8080/listRecruteur").success(function (respons) {
            $scope.rec = respons;
            console.log($scope.rec);
        })
    };
    $scope.consulterRec();

    $scope.consulterCand = function () {
        $http.get("http://localhost:8080/listCandidat").success(function (respons) {
            $scope.cand = respons;
            console.log($scope.cand);
        })
    };
    $scope.consulterCand();

    $scope.consulterOffre = function () {
        $http.get("http://localhost:8080/listOffre").success(function (respons) {
            $scope.offres = respons;
            console.log($scope.offres);
        })
    };
    $scope.consulterOffre();

    //for the ng show of "ajouter recruteur" we must initialize myForm on false
    $scope.myForm = false;
    $scope.formAjouterRec = function () {
        $scope.myForm = !$scope.myForm;
    };
    $scope.myFormModif = false;
    $scope.formModifierRec = function (re) {
        $scope.myFormModif = !$scope.myFormModif;
    };

    $scope.modifierRec = function (re) {
        console.log(re);
        console.log(recruteur);

        recruteur.login = re.login;
        recruteur.password = re.password;
        recruteur.nomRecruteur = re.nomRecruteur;
        recruteur.serviceRecruteur = re.serviceRecruteur;

        console.log(recruteur);

        $http.put("http://localhost:8080/modifierRec", recruteur).success(function (respons) {
                $scope.data = respons;
                console.log($scope.data);
                $scope.msg = "Recruteur Modifié !"
                $scope.consulterRec();
                $scope.re = null;
                $scope.msg = null;
                $scope.myFormModif = false;

            })
            .error(function (data, Status, Response) {
                $scope.data = data;
                $scope.status = Status;
                console.log(data);
                console.log(Response);
                console.log(Status);
                console.log('fail');
            });

    };
    $scope.ajouterRec = function (per) {
        console.log(per);
        console.log(recruteur);

        recruteur.login = per.login;
        recruteur.password = per.password;
        recruteur.nomRecruteur = per.nomRecruteur;
        recruteur.serviceRecruteur = per.serviceRecruteur;

        console.log(recruteur);

        $http.post("http://localhost:8080/ajouterRec", recruteur).success(function (respons) {
                $scope.data = respons;
                console.log($scope.data);
                $scope.msg = "Recruteur Ajouté !"
                $scope.consulterRec();
                $scope.per = null;
                $scope.msg = null;
                $scope.myForm = false;

            })
            .error(function (data, Status, Response) {
                $scope.data = data;
                $scope.status = Status;
                console.log(data);
                console.log(Response);
                console.log(Status);
                console.log('fail');
            });

    };
    $scope.supprimerRec = function (re) {

        $http.delete("http://localhost:8080/supRecruteur/" + re.id).success(function (respons) {
            $scope.consulterRec();
        })
    }
    $scope.supprimerCand = function (cand) {

        $http.delete("http://localhost:8080/supCandidat/" + cand.id).success(function (respons) {
            $scope.consulterCand();
        })
    }

    $scope.envoyerMail = function (mail) {
        console.log(mail);

        $http.post("http://localhost:8080/envoyerMail", mail).success(function (respons) {
            $scope.mail = respons;
            console.log($scope.mail);
            $scope.msg = "Votre Mail a été envoyé !"

        })

    }
}).controller('adminGestionTechnoCtrl', function ($scope, $rootScope, $http) {
    $scope.consulter = function () {

        $http.get("http://localhost:8080/listechno").success(function (respons) {
            $scope.rep = respons;
            console.log($scope.rep);
        })
    };
    $scope.consulter();

}).controller('recruteurCtrl', function ($scope, $http, $state, userIdService, userInscriService, listPostulantService) {


    var user = userInscriService.getValue();
    console.log(user.id);

    $scope.getListTechno = function () {
        $http.get("http://localhost:8080/listechno")
            .success(function (respons) {
                $scope.listTechno = respons;
            })
    };
    $scope.technologiesOffre = {};
    $scope.technologiesOffre.nomTechno = {};
    $scope.getListTechno();

    var newOffre = {
        'titreOffre': '',
        descOffre: '',
        deposeur: {
            id: '',
        },
        technologiesOffre:[ ],
        };

    $scope.ajouterOffre = function (offre) {
console.log($scope.offre.selectedTechno);

        newOffre.technologiesOffre.push({
            nomTechno: $scope.offre.selectedTechno,
        });
        newOffre.titreOffre = offre.titreOffre;
        newOffre.descOffre = offre.descOffre;
        newOffre.deposeur.id = user.id;


        console.log(newOffre);

        $http.post("http://localhost:8080/ajouterOffre", newOffre)
            .success(function (respons) {
                $scope.data = respons;
                console.log($scope.data);
                $scope.msg = "Offre Ajoutée !";
            })
            .error(function (data, Status, Response) {
                $scope.data = data;
                $scope.status = Status;
                console.log(data);
                console.log(Response);
                console.log(Status);
                console.log('fail');
            });
    };
    $scope.getMesOffres = function () {
        $http.get("http://localhost:8080/voirOffre/" + user.id)
            .success(function (respons) {
                $scope.mesOffres = respons;
                console.log(JSON.stringify($scope.mesOffres));

            })
    };
    $scope.getMesOffres();

    $scope.envoyerMail = function (mail) {
        console.log(mail);

        $http.post("http://localhost:8080/envoyerMail", mail)

            .success(function (respons) {
            $scope.mail = respons;
            console.log($scope.mail);
            $scope.msg = "Votre Mail a été envoyé !"
        })
    };
    $scope.listPostulant = function (id) {

        console.log(id);
        $http.get("http://localhost:8080/postulantOffre/" + id).success(function (respons) {
            $scope.listPostulant = respons;
            listPostulantService.setValue($scope.listPostulant);
            $state.go('appR.recruteurListPostulant');
            console.log($scope.listPostulant);
        })
    };

    $scope.supprimerOffre = function (id) {

        $http.delete("http://localhost:8080/supOffre/" + id)
            .success(function (respons) {
                $scope.getMesOffres();
            })
    }


}).controller('recruteurListPostulant', function ($scope, $state, $http, listPostulantService, profilDataService) {
    $scope.listPostulant = listPostulantService.getValue();


    $scope.profilPostulant = function (candidat) {

        $scope.profil = candidat;
        $state.go('appR.recruteurVoirProfilCandidat');
        console.log($scope.profil);
        profilDataService.setValue($scope.profil);
    };

    $scope.profilData = profilDataService.getValue();

    $scope.myFormMail = false;
    $scope.formEnvoyerMail = function () {
        $scope.myFormMail = !$scope.myFormMail;
    };
    var newMail = {
        'to': '',
        subject: '',
        body: '',
    }
    $scope.envoyerMail = function (mail, to) {
        console.log(mail);

                newMail.to= to;
                newMail.subject= mail.subject;
                newMail.body= mail.body;


        $http.post("http://localhost:8080/envoyerMail", newMail).success(function (respons) {
            $scope.mail = respons;
            console.log(newMail);
            $scope.msg = "Votre Mail a été envoyé !"
        })
    };


}).controller('profileCtrl', function ($scope, profilDataService) {
    $scope.profilData = profilDataService.getValue();

    console.log("ok");
    console.log($scope.profilData);

    $scope.editorEnabled = true;


}).controller('candidatCtrl', function ($scope, $http, userInscriService) {
    $scope.consulterOffre = function () {
        $http.get("http://localhost:8080/listOffre").success(function (respons) {
            $scope.offres = respons;
            console.log($scope.offres);
        })
    };
    $scope.consulterOffre();

    var user = userInscriService.getValue();

    $scope.postuler = function (offre) {

        console.log(offre.idOffre);
        $http.get("http://localhost:8080/user/" + user.id + "/offre/" + offre.idOffre).success(function (respons) {
            $scope.rep = respons;
            console.log($scope.rep);
            offre.selected=!offre.selected;

        })
    };
    $scope.consulterCandidatures = function () {
        $http.get("http://localhost:8080/candidatures/" + user.id).success(function (respons) {
            $scope.candidatures = respons;
            console.log($scope.candidatures);
        })
    };
    $scope.consulterCandidatures();

});

