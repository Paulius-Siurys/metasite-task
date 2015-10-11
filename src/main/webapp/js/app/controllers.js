(function () {

	var am = angular.module('metasite');

	am.controller('AppController', ['$scope', 'wordService', 'NgTableParams', '$q',
	        function ($scope, wordService, NgTableParams, $q) {

        $scope.wordList = {};

		var loadWordTable = function ($defer, params) {
            wordService.list('AG').success(function(data){
				$defer.resolve(data.wordList);
			});
		};

        $scope.tableParams = new NgTableParams({}, {getData:loadWordTable});

        $scope.uploadFile = function() {
            var file = $scope.file;
            wordService.uploadFile(file)
            .success(function(){
                $scope.tableParams.reload();
            })
            .error(function(){
            });
	    };
	}]);
})();