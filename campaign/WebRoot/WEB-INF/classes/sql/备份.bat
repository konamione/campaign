set Ymd=%date:~,4%%date:~5,2%%date:~8,2%%time:~0,2%%time:~3,2%%time:~6,2%
md D:\���ݱ���\%Ymd%
"D:\wamp\bin\mysql\mysql5.5.24\bin\mysqldump.exe" --opt -Q compaignDB -uroot -proot > D:\���ݱ���\%Ymd%\campaign.sql 
echo ���ݿⱸ����...
echo ���ݿⱸ�����