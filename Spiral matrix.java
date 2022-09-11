Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Solution : 



     //      l   r  
     //  t  [1 2 3 ]
     //     [4 5 6 ]
    //   b  [7 8 9 ]

// 1 2 3    d = 1      first row 
// 6 9      d = 2      last col
// 8 7      d = 3      last row
// 4        d = 4      first col 

// repeat the above 4 steps 




code: 

class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
       int row = mat.length , col = mat[0].length ; 
        List<Integer> list = new ArrayList<>(); 
        if(row == 0)
            return list ; 
        
        int  l = 0 , r = col - 1 , t = 0 , b =  row - 1 , d = 1 ; 
        while(t <= b && l <= r){
            if(d == 1)
            {
                for(int i = l ; i <= r ; i++)
                    list.add(mat[t][i]);
                t++;
                d = 2 ;
            }
            else if(d == 2)
            {
                for(int i = t ; i <= b ; i++)
                    list.add(mat[i][r]);
                r--;
                d = 3 ;
            }
            else if(d == 3)
            {
                for(int i = r ; i >= l ; i--)
                    list.add(mat[b][i]);
                b--;
                d = 4 ;
            }
            else if(d == 4)
            {
                for(int i = b ; i >= t ; i--)
                    list.add(mat[i][l]);
                l++;
                d = 1 ;
            }
            
        }
        return list;
    }
}



