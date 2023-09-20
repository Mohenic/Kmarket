	window.onload = function(){
		document.getElementById('cateSelect').addEventListener('change', function() {
		    var selectedValue = this.value;
		    // 페이지 리로드
		    window.location.href = "/Kmarket/admin/cs/notice/list.do?group=notice&cate=" + selectedValue;
		});
	}
