/**
 * leftBox.js
 */
let isLoggedIn = false; // 로그인 상태를 나타내는 변수

// 로그인/로그아웃 상태 변경 함수
function toggleLogin() {
    isLoggedIn = !isLoggedIn;
    updateLayout();
}

// 레이아웃 업데이트 함수
function updateLayout() {
    if (isLoggedIn) {
        // 로그인 상태
        document.getElementById('left-column').classList.remove('w3-hide-left');
        document.getElementById('right-column').classList.remove('w3-expand-right');
    } else {
        // 로그아웃 상태
        document.getElementById('left-column').classList.add('w3-hide-left');
        document.getElementById('right-column').classList.add('w3-expand-right');
    }
}

// 초기 상태 설정
updateLayout();
