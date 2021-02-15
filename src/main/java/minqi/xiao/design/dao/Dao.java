package minqi.xiao.design.dao;

import minqi.xiao.design.model.Character;
import minqi.xiao.design.model.Word;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Dao {

    //Word:查最大数
    @Select("select count(*) from memory_word")
    public int getWordNum();
    //Word：取值
    @Select("select word,word_mean,analysis,memory from memory_word where id = #{id}")
    public Word getWordById(Integer id);
    //Character:查最大值
    @Select("select count(*) from memory_character")
    public int getCharacterNum();
    //Character：取值
    @Select("select * from memory_character where id = #{id}")
    public Character getCharacterById(Integer id);

}
