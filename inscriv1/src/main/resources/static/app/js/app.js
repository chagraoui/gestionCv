'use strict';

var app = angular.module('xenon-app', [
	'ngCookies',
	'ui.router',
	'ui.bootstrap',
	'ui.select',
	'ngSanitize',
	'oc.lazyLoad',
	'xenon.controllers',
	'xenon.directives',
	'xenon.factory',
	'xenon.services',

	// Added in v1.3
	'FBAngular'
]);

app.run(function()
{
	// Page Loading Overlay
	public_vars.$pageLoadingOverlay = jQuery('.page-loading-overlay');

	jQuery(window).load(function()
	{
		public_vars.$pageLoadingOverlay.addClass('loaded');
	})
});

app.config(function($stateProvider, $urlRouterProvider, $ocLazyLoadProvider, ASSETS){

	$urlRouterProvider.otherwise('/login-light');

	$stateProvider.
		// Main Layout Structure
		state('app', {
			abstract: true,
			url: '/app',
			templateUrl: appHelper.templatePath('/layout/app-body'),
			controller: function($rootScope){
				$rootScope.isLoginPage        = false;
				$rootScope.isLightLoginPage   = false;
				$rootScope.isLockscreenPage   = false;
				$rootScope.isMainPage         = true;
			}
		}).


		// Main Layout Structure
		state('appR', {
			abstract: true,
			url: '/appR',
			templateUrl: appHelper.templatePath('/layoutRec/app-body'),
			controller: function($rootScope){
				$rootScope.isLoginPage        = false;
				$rootScope.isLightLoginPage   = false;
				$rootScope.isLockscreenPage   = false;
				$rootScope.isMainPage         = true;
			}
		}).
	state('appC', {
			abstract: true,
			url: '/appC',
			templateUrl: appHelper.templatePath('/layoutCand/app-body'),
			controller: function($rootScope){
				$rootScope.isLoginPage        = false;
				$rootScope.isLightLoginPage   = false;
				$rootScope.isLockscreenPage   = false;
				$rootScope.isMainPage         = true;
			}
		}).

		state('app.mailbox-compose', {
			url: '/mailbox-compose',
			templateUrl: appHelper.templatePath('mailbox/compose'),
			controller: 'adminGestionCtrl',
			resolve: {
				bootstrap: function($ocLazyLoad){
					return $ocLazyLoad.load([
						ASSETS.core.bootstrap,
					]);
				},
				bootstrapWysihtml5: function($ocLazyLoad){
					return $ocLazyLoad.load([
						ASSETS.forms.bootstrapWysihtml5,
					]);
				},
			}
		}).

		// Logins and Lockscreen
		state('login-light', {
			url: '/login-light',
			templateUrl: appHelper.templatePath('login-light'),
			controller: 'LoginLightCtrl',
			resolve: {
				resources: function($ocLazyLoad){
					return $ocLazyLoad.load([
						ASSETS.forms.jQueryValidate,
					]);
				},
			}
		}).

	state('forgottenPassword', {
			url: '/forgottenPassword',
			templateUrl: appHelper.templatePath('forgottenPassword'),
		resolve: {
			resources: function($ocLazyLoad){
				return $ocLazyLoad.load([
					ASSETS.forms.jQueryValidate,
				]);
			},
		}
		}).

	state('inscri1', {
		url: '/inscription1',
		templateUrl: appHelper.templatePath('inscription1'),
		controller: 'fileCtrl',
		resolve: {
			resources: function($ocLazyLoad){
				return $ocLazyLoad.load([
					ASSETS.forms.jQueryValidate,
				]);
			},
		}
	}).

	state('inscri2', {
		url: '/inscription2',
		templateUrl: appHelper.templatePath('inscription2'),
		controller: 'inscriCtrl',
		resolve: {
			resources: function($ocLazyLoad){
				return $ocLazyLoad.load([
					ASSETS.forms.jQueryValidate,
				]);
			},
		}
	}).
	state('app.adminGestion', {
		url: '/adminGestionRec',
		templateUrl: appHelper.templatePath('users/admin/adminGestionRec'),
		controller: 'adminGestionCtrl',
		resolve: {
			resources: function($ocLazyLoad){
				return $ocLazyLoad.load([
					ASSETS.forms.jQueryValidate,
				]);
			},
		}
	}).

	state('app.adminGestionCand', {
		url: '/adminGestionCand',
		templateUrl: appHelper.templatePath('users/admin/adminGestionCand'),
		controller: 'adminGestionCtrl',
		resolve: {
			resources: function($ocLazyLoad){
				return $ocLazyLoad.load([
					ASSETS.forms.jQueryValidate,
				]);
			},
		}
	}).

	state('app.adminGestionTechno', {
		url: '/adminGestionTechno',
		templateUrl: appHelper.templatePath('users/admin/adminGestionTechno'),
		controller: 'adminGestionTechnoCtrl',
		resolve: {
			resources: function($ocLazyLoad){
				return $ocLazyLoad.load([
					ASSETS.forms.jQueryValidate,
				]);
			},
		}
	}).

	state('app.adminConsulterOffres', {
		url: '/consulterOffres',
		templateUrl: appHelper.templatePath('users/admin/consulterOffres'),
		controller: 'adminGestionCtrl',
		resolve: {
			resources: function($ocLazyLoad){
				return $ocLazyLoad.load([
					ASSETS.forms.jQueryValidate,
				]);
			},
		}
	}).

	state('appC.candidat', {
		url: '/candidat',
		templateUrl: appHelper.templatePath('users/candidat/profileCand'),
		controller: 'profileCtrl',
	}).

	state('appC.candidatOffre', {
		url: '/consulterTousOffres',
		templateUrl: appHelper.templatePath('users/candidat/consulterTousOffres'),
		controller: 'candidatCtrl',
	}).

	state('appC.mesCandidatures', {
		url: '/mesCandidatures',
		templateUrl: appHelper.templatePath('users/candidat/mesCandidatures'),
		controller: 'candidatCtrl',
	}).

		state('appR.recruteur', {
			url: '/epsaceRecruteur',
			templateUrl: appHelper.templatePath('users/recruteur/consulterMesOffres'),
			controller: 'recruteurCtrl',
		}).
	state('appR.recruteurMail', {
			url: '/composeMail',
			templateUrl: appHelper.templatePath('users/recruteur/composeMail'),
			controller: 'recruteurCtrl',
		}).

	state('appR.recruteurListPostulant', {
		url: '/listPostulant',
		templateUrl: appHelper.templatePath('users/recruteur/candidatureParOffre'),
		controller: 'recruteurListPostulant',
	}).

	state('appR.recruteurVoirProfilCandidat', {
		url: '/voirProfilCandidat',
		templateUrl: appHelper.templatePath('users/recruteur/voirProfilCandidat'),
		controller: 'recruteurListPostulant',
	}).

	state('appR.recruteuroffre', {
		url: '/ajouteroffre',
		templateUrl: appHelper.templatePath('users/recruteur/ajouterOffre'),
		controller: 'recruteurCtrl',
	})
});


app.constant('ASSETS', {
	'core': {
		'bootstrap': appHelper.assetPath('js/bootstrap.min.js'), // Some plugins which do not support angular needs this

		'jQueryUI': [
			appHelper.assetPath('js/jquery-ui/jquery-ui.min.js'),
			appHelper.assetPath('js/jquery-ui/jquery-ui.structure.min.css'),
		],

		'moment': appHelper.assetPath('js/moment.min.js'),

		'googleMapsLoader': appHelper.assetPath('app/js/angular-google-maps/load-google-maps.js')
	},

	'xenonLib': {
		notes: appHelper.assetPath('js/xenon-notes.js'),
	},

	'icons': {
		'meteocons': appHelper.assetPath('css/fonts/meteocons/css/meteocons.css'),
		'elusive': appHelper.assetPath('css/fonts/elusive/css/elusive.css'),
	},

	'tables': {
		'rwd': appHelper.assetPath('js/rwd-table/js/rwd-table.min.js'),

		'datatables': [
			appHelper.assetPath('js/datatables/dataTables.bootstrap.css'),
			appHelper.assetPath('js/datatables/datatables-angular.js'),
		],

	},

	'forms': {

		'select2': [
			appHelper.assetPath('js/select2/select2.css'),
			appHelper.assetPath('js/select2/select2-bootstrap.css'),

			appHelper.assetPath('js/select2/select2.min.js'),
		],

		'daterangepicker': [
			appHelper.assetPath('js/daterangepicker/daterangepicker-bs3.css'),
			appHelper.assetPath('js/daterangepicker/daterangepicker.js'),
		],

		'colorpicker': appHelper.assetPath('js/colorpicker/bootstrap-colorpicker.min.js'),

		'selectboxit': appHelper.assetPath('js/selectboxit/jquery.selectBoxIt.js'),

		'tagsinput': appHelper.assetPath('js/tagsinput/bootstrap-tagsinput.min.js'),

		'datepicker': appHelper.assetPath('js/datepicker/bootstrap-datepicker.js'),

		'timepicker': appHelper.assetPath('js/timepicker/bootstrap-timepicker.min.js'),

		'inputmask': appHelper.assetPath('js/inputmask/jquery.inputmask.bundle.js'),

		'formWizard': appHelper.assetPath('js/formwizard/jquery.bootstrap.wizard.min.js'),

		'jQueryValidate': appHelper.assetPath('js/jquery-validate/jquery.validate.min.js'),

		'dropzone': [
			appHelper.assetPath('js/dropzone/css/dropzone.css'),
			appHelper.assetPath('js/dropzone/dropzone.min.js'),
		],

		'typeahead': [
			appHelper.assetPath('js/typeahead.bundle.js'),
			appHelper.assetPath('js/handlebars.min.js'),
		],

		'multiSelect': [
			appHelper.assetPath('js/multiselect/css/multi-select.css'),
			appHelper.assetPath('js/multiselect/js/jquery.multi-select.js'),
		],

		'icheck': [
			appHelper.assetPath('js/icheck/skins/all.css'),
			appHelper.assetPath('js/icheck/icheck.min.js'),
		],

		'bootstrapWysihtml5': [
			appHelper.assetPath('js/wysihtml5/src/bootstrap-wysihtml5.css'),
			appHelper.assetPath('js/wysihtml5/wysihtml5-angular.js')
		],
	},

	'uikit': {
		'base': [
			appHelper.assetPath('js/uikit/uikit.css'),
			appHelper.assetPath('js/uikit/css/addons/uikit.almost-flat.addons.min.css'),
			appHelper.assetPath('js/uikit/js/uikit.min.js'),
		],

		'codemirror': [
			appHelper.assetPath('js/uikit/vendor/codemirror/codemirror.js'),
			appHelper.assetPath('js/uikit/vendor/codemirror/codemirror.css'),
		],

		'marked': appHelper.assetPath('js/uikit/vendor/marked.js'),
		'htmleditor': appHelper.assetPath('js/uikit/js/addons/htmleditor.min.js'),
		'nestable': appHelper.assetPath('js/uikit/js/addons/nestable.min.js'),
	},

	'extra': {
		'tocify': appHelper.assetPath('js/tocify/jquery.tocify.min.js'),

		'toastr': appHelper.assetPath('js/toastr/toastr.min.js'),

		'fullCalendar': [
			appHelper.assetPath('js/fullcalendar/fullcalendar.min.css'),
			appHelper.assetPath('js/fullcalendar/fullcalendar.min.js'),
		],

		'cropper': [
			appHelper.assetPath('js/cropper/cropper.min.js'),
			appHelper.assetPath('js/cropper/cropper.min.css'),
		]
	}
});
app.filter('propsFilter', function() {
	return function(items, props) {
		var out = [];

		if (angular.isArray(items)) {
			items.forEach(function(item) {
				var itemMatches = false;

				var keys = Object.keys(props);
				for (var i = 0; i < keys.length; i++) {
					var prop = keys[i];
					var text = props[prop].toLowerCase();
					if (item[prop].toString().toLowerCase().indexOf(text) !== -1) {
						itemMatches = true;
						break;
					}
				}

				if (itemMatches) {
					out.push(item);
				}
			});
		} else {
			// Let the output be the input untouched
			out = items;
		}

		return out;
	}
});