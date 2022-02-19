USE MEMBER;

CREATE TABLE Member
(
    MemberID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100)
);

-- 테스트용 더미 데이터
INSERT INTO Member(Name) Values('관리자');
INSERT INTO Member(Name) Values('박상곤');
INSERT INTO Member(Name) Values('이름없음');