#define EPS  0.0000001
        #define  PI  3.14159265358979323846

        int main(){
        float x;
        float y;
        cin >> x;
        cin >> y;
        pt p = {x,y};
        float *angle;
        if (GetAngleForPoint(p,*angle))
        {
        cout<<angle;
        }


        }
        struct pt
        {
            float x;
            float y;
        };

//获取所在象限
        int GetQuadrantForPoint(pt  p)
        {
            if(p.x > 0 && p.y > 0) //第一象限
                return 1;
            else if(abs(p.x - 0)<EPS && p.y > 0) //在y轴正方向
                return  12;
            else if(p.x<0 && p.y>0) //2
            {
                return 2;
            }
            else if(p.x<0&& abs(p.y-0)<EPS) //-x
            {
                return 23;
            }
            else if(p.x<0&& p.y<0) //3
            {
                return 3;
            }
            else if(abs(p.x-0)<EPS && p.y<0) //-y
            {
                return 34;
            }
            else if(p.x>0&& p.y<0) //4
            {
                return 4;
            }
            else if(p.x>0&& abs(p.y-0)<EPS) //+x
            {
                return 41;
            }
            else if(abs(p.x-0)<EPS && abs(p.y-0)<EPS) //o
            {
                return 0;
            }
            else
            {
                return -1;
            }
        }

//获取角度
        BOOL GetAngleForPoint(pt p,float *angle)
        {
            float x=abs(p.x);
            float y=abs(p.y);
            if(GetQuadrantForPoint(p) == 12)
            {
                *angle = 90.00;
            }
            else if(GetQuadrantForPoint(p) == 23)
            {
                *angle = 180.00;
            }
            else if(GetQuadrantForPoint(p) == 34)
            {
                *angle = 270.00;
            }
            else if(GetQuadrantForPoint(p) == 41)
            {
                *angle = 0.00;
            }
            else if(GetQuadrantForPoint(p) == 1)
            {
                *angle = atan(y/x)/PI*180;
            }
            else if(GetQuadrantForPoint(p) == 2)
            {
                *angle = atan(x/y)/PI*180+90;
            }
            else if(GetQuadrantForPoint(p) == 3)
            {
                *angle = atan(y/x)/PI*180+180;
            }
            else if(GetQuadrantForPoint(p) == 4)
            {
                *angle = atan(x/y)/PI*180+270;
            }
            else
            {
                return 0;
            }
            return 1;
        }
