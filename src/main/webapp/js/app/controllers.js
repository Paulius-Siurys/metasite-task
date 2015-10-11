(function () {

	var am = angular.module('metasite');

	am.controller('AppController', ['$scope', 'wordService', 'NgTableParams', '$q',
	        function ($scope, wordService, NgTableParams, $q) {

	    $scope.firstLetterIntervalList = [{name: 'A-G', value: 'AG'}, {name: 'H-N', value: 'HN'},
	        {name: 'O-U', value: 'OU'}, {name: 'V-Z', value: 'VZ'}];
	    $scope.firstLetterInterval = $scope.firstLetterIntervalList[0].value;

	    var setMessage = function(message) {
	        $scope.message = message;
	    };

		var loadWordTable = function($defer, params) {
            wordService.list($scope.firstLetterInterval, params.page(), params.count()).success(function(data){
                $scope.tableParams.total(data.totalElements);
				$defer.resolve(data.wordList);
			}).error(function() {
                setMessage('Klaida bandant gauti žodžių sąrašą');
            });
		};

        $scope.tableParams = new NgTableParams({}, {getData:loadWordTable});

        $scope.firstLetterIntervalChange = function() {
            $scope.tableParams.reload();
        };

        $scope.uploadFile = function() {
            var file = $scope.file;
            wordService.uploadFile(file).success(function() {
                $scope.tableParams.reload();
                setMessage('Failo įkėlimas sėkmingas');
            }).error(function() {
                setMessage('Klaida įkeliant failą');
            });
	    };
	}]);
})();