set Ymd=%date:~,4%%date:~5,2%%date:~8,2%%time:~0,2%%time:~3,2%%time:~6,2%
md D:\数据备份\%Ymd%
"D:\wamp\bin\mysql\mysql5.5.24\bin\mysqldump.exe" --opt -Q compaignDB -uroot -proot > D:\数据备份\%Ymd%\campaign.sql 
echo 数据库备份中...
echo 数据库备份完成