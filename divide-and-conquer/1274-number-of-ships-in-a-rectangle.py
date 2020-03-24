# """
# This is Sea's API interface.
# You should not implement it, or speculate about its implementation
# """

class Sea(object):
    def hasShips(self, topRight: 'Point', bottomLeft: 'Point') -> bool:
        pass


class Point(object):
    def __init__(self, x: int, y: int):
        self.x = x
        self.y = y


class Solution(object):
    def countShips(self, sea: 'Sea', topRight: 'Point', bottomLeft: 'Point') -> int:
        top_right_x = topRight.x
        top_right_y = topRight.y
        bottom_left_x = bottomLeft.x
        bottom_left_y = bottomLeft.y

        if bottom_left_x > top_right_x or bottom_left_y > top_right_y or not sea.hasShips(topRight, bottomLeft):
            return 0

        if bottom_left_x == top_right_x and bottom_left_y == top_right_y:
            return 1

        mid_x = (bottom_left_x + top_right_x) >> 1
        mid_y = (bottom_left_y + top_right_y) >> 1
        blocks = [[Point(mid_x, top_right_y), Point(bottom_left_x, mid_y + 1)],
                  [Point(top_right_x, top_right_y), Point(mid_x + 1, mid_y + 1)],
                  [Point(top_right_x, mid_y), Point(mid_x + 1, bottom_left_y)],
                  [Point(mid_x, mid_y), Point(bottom_left_x, bottom_left_y)]]

        res = 0
        for block in blocks:
            top_right_coord = block[0]
            bottom_left_coord = block[1]
            res += self.countShips(sea, top_right_coord, bottom_left_coord)
            if res == 10:
                return res
        return res
