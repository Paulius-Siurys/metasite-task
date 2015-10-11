(function () {

	var am = angular.module('metasite');

	am.service('fileUploadService', ['$http', function ($http) {
    }]);

	am.service('wordService', ['$http', function ($http) {
	    this.uploadFile = function(file) {
            var fd = new FormData();
            fd.append('file', file);
            return $http.post('action/file/upload', fd, {
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
            });
        };
        this.list = function(firstLetterIntervalEnum, page, pageSize) {
            return $http.get('action/word/list/' + firstLetterIntervalEnum + "/" + page + "/" + pageSize, {});
        };
    }]);
})();