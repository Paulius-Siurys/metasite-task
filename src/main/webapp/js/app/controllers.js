(function () {

	var am = angular.module('metasite');

	am.controller('AppController', ['$scope', 'wordService', 'NgTableParams', '$q',
	        function ($scope, wordService, NgTableParams, $q) {

	    $scope.firstLetterIntervalList = ['AG', 'HN', 'OU', 'VZ'];
	    $scope.firstLetterInterval = 'AG';

		var loadWordTable = function($defer, params) {
            wordService.list($scope.firstLetterInterval, params.page(), params.count()).success(function(data){
                $scope.tableParams.total(data.totalElements);
				$defer.resolve(data.wordList);
			});
		};

        $scope.tableParams = new NgTableParams({}, {getData:loadWordTable});

        $scope.firstLetterIntervalChange = function() {
            $scope.tableParams.reload();
        };

        $scope.uploadFile = function() {
            var file = $scope.file;
            wordService.uploadFile(file)
            .success(function() {
                $scope.tableParams.reload();
            })
            .error(function() {
            });
	    };
	}]);
})();