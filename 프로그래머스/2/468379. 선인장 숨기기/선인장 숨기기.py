from collections import deque

def sliding_min(arr, k):
    dq = deque()              # 인덱스 저장. arr[인덱스]가 오름차순
    out = []
    for i, v in enumerate(arr):
        while dq and arr[dq[-1]] >= v:
            dq.pop()          # 새 값보다 큰 후보는 버림
        dq.append(i)
        if dq[0] <= i - k:
            dq.popleft()      # 창을 벗어난 인덱스 제거
        if i >= k - 1:
            out.append(arr[dq[0]])    # 첫 창이 완성된 뒤부터 기록
    return out


def solution(m, n, h, w, drops):
    INF = float('inf')
    board = [[INF] * n for _ in range(m)]
    for idx, (x, y) in enumerate(drops, 1):
        board[x][y] = idx

    # 1단계: 행 방향, 너비 w → m x (n-w+1)
    rows = [sliding_min(row, w) for row in board]

    # 2단계: 열 방향, 높이 h → (m-h+1) x (n-w+1)
    cols_t = []                          # 열마다 결과를 저장 (전치된 형태)
    for j in range(n - w + 1):
        col = [rows[i][j] for i in range(m)]
        cols_t.append(sliding_min(col, h))

    answer = [0, 0]
    num = 0
    for i in range(m - h + 1):
        for j in range(n - w + 1):
            res = cols_t[j][i]           # cols_t[열][행] 순서에 주의
            if res == INF:
                return [i, j]
            if res > num:
                num = res
                answer = [i, j]
    return answer