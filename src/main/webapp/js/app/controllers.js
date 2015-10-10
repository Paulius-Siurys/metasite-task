(function () {

	var am = angular.module('metasite');

	am.controller('AppController', ['$scope', 'fileUploadService',
	        function ($scope, fileUploadService) {

        $scope.uploadFile = function() {
            var file = $scope.file;
            fileUploadService.uploadFileToUrl(file);
	    };
	}]);
})();