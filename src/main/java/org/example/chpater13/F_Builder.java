package org.example.chpater13;

/*
   == 빌더로 게임 캐릭터 생성 ==
   1) 필수: 이름(String), 분류(String)
   2) 선택: 스킬(String), 아이템(String)

 */

class GameCharacter {
    private final String name;
    private final String sort;

    private final String skill;
    private final String item;

    // 1. Builder 클래스
    public static class Builder {
        private final String name;
        private final String sort;

        private String skill = "Basic Attack";
        private String item = "None";

        public Builder(String name, String sort) {
            this.name = name;
            this.sort = sort;
        }

        // 선택 필드에 대한 할당 메서드 (필드명 그 자체의 메서드명을 가짐)
        public Builder skill(String skill) {
            this.skill = skill;
            return this;
        }

        public Builder item(String item) {
            this.item = item;
            return this;
        }

        public GameCharacter build() {
            return new GameCharacter(this);
        }
    }

    public GameCharacter(Builder builder) {
        this.name = builder.name;
        this.sort = builder.sort;

        this.skill = builder.skill;
        this.item = builder.item;
    }

    @Override
    public String toString() {
        return "GameCharacter{" +
                "name='" + name + '\'' +
                ", sort='" + sort + '\'' +
                ", skill='" + skill + '\'' +
                ", item='" + item + '\'' +
                '}';
    }
}
public class F_Builder {
    public static void main(String[] args) {
        GameCharacter character1 = new GameCharacter.Builder("럭스", "마법사")
                .skill("가두기")
                .item("마법사 신발")
                .build();
        GameCharacter character2 = new GameCharacter.Builder("가렌", "전사")
                .skill("침묵")
                .item("루비 수정")
                .build();

        System.out.println(character1);
        System.out.println(character2);
    }
}
